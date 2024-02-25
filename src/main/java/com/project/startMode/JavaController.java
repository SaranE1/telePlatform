package com.project.startMode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.project.startMode.model.ChatPromptModel;
import com.project.startMode.model.ChatRequestModel;
import com.project.startMode.model.ChatResponseModel;
import com.project.startMode.model.EmailDetails;
import com.project.startMode.model.HomeIndex;
import com.project.startMode.model.PatientSentData;
import com.project.startMode.repo.DrugRepo;
import com.project.startMode.repo.EmailData;
import com.project.startMode.repo.JavaRepo;
import com.project.startMode.service.EmailService;

@Controller
public class JavaController {

    @GetMapping("/")
    public String index() {
        return "ChooseIndex";
    }

    @Autowired
    JavaRepo repo;

    @PostMapping("register")
    public String register(HomeIndex value) {
        repo.save(value);
        return "success";
    }

    @RequestMapping("showAll")
    public String showAll(Model model) {
        // List<HomeIndex> data = repo.findAll();
        model.addAttribute("allData", repo.findAll());
        return "showAll";
    }

    @RequestMapping("showAl")
    public String showValue(@RequestParam("keyWord") String keyWord, Model model) {
        System.out.println(keyWord);
        model.addAttribute("allData", repo.findByFnameContainingOrLnameContaining(keyWord, keyWord));
        return "showAll";
    }

    @Autowired
    private EmailData emailDataRepo;

    @GetMapping("sendEmail")
    public String showMailPage() {
        return "emailPdf.html";
    }

    // @PostMapping("sendEmail")
    // public String sendEmail(@RequestBody EmailDetails emailDetails) {
    // System.out.println(emailDetails);
    // String status = emailService.sendEmail(emailDetails);
    // System.out.println(status);
    // emailDataRepo.save(emailDetails);
    // return "success";
    // }

    // @GetMapping("sendEmailWithAttachment")
    // public String showMailPagePro() {
    // return "emailPro.html";
    // }

    // For Future Use

    // @PostMapping("sendEmailWithAttachment")
    // public String sendEmailWithAttachment(EmailDetails emailDetails) {
    // System.out.println(emailDetails.getAttachment());
    // String status = emailService.sendEmailWithAttachment(emailDetails);
    // System.out.println(status);
    // emailDataRepo.save(emailDetails);
    // return "success";
    // }

    @Autowired
    private EmailService service;

    @Autowired
    private EmailData emailRepo;

    @GetMapping("fixAppointment")
    public String patientRequest() {
        // return "PatientRequest";
        return "fixAppointment";
    }

    @PostMapping("patientDataStore")
    public String patientRequest(PatientSentData patientSentData) {
        emailRepo.save(patientSentData);
        return "redirect:fixAppointment";
    }

    @RequestMapping("showPatientDetails")
    public String showPatientRecords(Model model) {

        model.addAttribute("allData", emailDataRepo.findAll());
        return "showDetails.html";
    }

    @GetMapping("sendPrescription")
    public String sendPrescription() {
        return "PrescriptionTemp";
    }

    @PostMapping("sendEmailToPatient")
    public String sendFreeMark(EmailDetails emailDetails) {
        Map<String, Object> model = new HashMap<>();
        model.put("recipient", emailDetails.getRecipient());
        model.put("patientName", emailDetails.getPatientName());
        model.put("patientAge", emailDetails.getPatientAge());
        model.put("gender", emailDetails.getGender());
        model.put("medicineName1", emailDetails.getMedicineName1());
        model.put("dosage1", emailDetails.getDosage1());
        model.put("dayNight1", emailDetails.getDayNight1());
        model.put("medicineName2", emailDetails.getMedicineName2());
        model.put("dosage2", emailDetails.getDosage2());
        model.put("dayNight2", emailDetails.getDayNight2());
        String response = service.sendFreeMark(emailDetails, model);
        System.out.println(response);
        return "success";
    }

    @PostMapping("accept/{id}")
    public String accept(@PathVariable String id) {
        // String mailId = id;
        emailRepo.deleteById(id);
        service.acceptMail(id);
        return "redirect:/showPatientDetails";
    }

    // Chat Integration model

    @RequestMapping("chat")
    public String openAi() {
        return "chat";
    }

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("chatOut")
    public String openAi(ChatPromptModel chatPromptModel, Model model) {
        String prompt = "Symptoms: " + chatPromptModel.getSymptoms() + " Days: " + chatPromptModel.getDays()
                + " Provide me the heath tips in 40 words and tell me the specific domain doctor i need to consult in this format \"Health Tips:\" and in the next line \"Domain Doctor:\" and in the next line \"Medicine Name:\"";
        System.out.println(prompt);
        ChatRequestModel requestModel = new ChatRequestModel("gpt-3.5-turbo", prompt);
        ChatResponseModel responseModel = restTemplate.postForObject("https://api.openai.com/v1/chat/completions",
                requestModel, ChatResponseModel.class);

        System.out.println(responseModel.getChoices().get(0).getMessage().getContent());
        String chatResult = responseModel.getChoices().get(0).getMessage().getContent();
        System.out.println(chatResult);
        model.addAttribute("chatResult", chatResult);
        // responseModel.getChoices().get(0).getMessage().getContent();
        return "chat";
    }

    // show all the drug details

    @Autowired
    DrugRepo drugRepo;

    @RequestMapping("showDrug")
    public String showDrug(Model model) {
        // List<DrugModel> res = drugRepo.findAll();
        // System.out.println(res);
        // model.addAttribute("allData", drugRepo.findAll());
        return "showDrug";
    }

    @RequestMapping("showDru")
    public String showDrug(@RequestParam("keyWord") String keyWord, Model model) {
        System.out.println(keyWord);
        model.addAttribute("allData",
                drugRepo.findTop10ByDrugNameContainingOrShortCom1ContainingOrShortCom2Containing(keyWord, keyWord,
                        keyWord));
        return "showDrug";
    }

    @GetMapping("digital")
    public String prescription() {
        return "prescription";
    }

    @GetMapping("doctorPortal")
    public String doctorPortal() {
        return "doctorPortal/portalIndex.html";
    }

    @GetMapping("brain")
    public String brain() {
        return "doctorPortal/brain";
    }
}
