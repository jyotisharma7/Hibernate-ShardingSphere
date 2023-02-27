package com.stackabuse.hibernatedemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PhoneController {

  @Autowired
  private PhoneRepository phoneRepository;

  @GetMapping("/phones")
  public List<Phone> getAllPhones() {
    return phoneRepository.findAll();
  }

  @GetMapping("/phones/{id}")
  public ResponseEntity<Phone> getPhoneById(@PathVariable(value = "id") UUID phoneId) throws Exception {

    Phone phone = phoneRepository.findById(phoneId).orElseThrow(() -> new Exception("Phone " + phoneId + " not found"));
    return ResponseEntity.ok().body(phone);
  }

  @PostMapping("/phones")
  public Phone createPhone(@Valid @RequestBody Phone phone) {
    // phone.setId(UUID.randomUUID());
    System.out.println("phone" + phone.getId() + phone.getOs() + phone.getPhoneName());
    return phoneRepository.save(phone);
  }

  @PutMapping("/phones/{id}")
  public ResponseEntity<Phone> updatePhone(@PathVariable(value = "id") UUID phoneId,
      @Valid @RequestBody Phone phoneDetails) throws Exception {

    Phone phone = phoneRepository.findById(phoneId).orElseThrow(() -> new Exception("Phone " + phoneId + " not found"));

    final Phone updatedPhone = phoneRepository.save(phone);
    return ResponseEntity.ok(updatedPhone);
  }

  @DeleteMapping("/phone/{id}")
  public Map<String, Boolean> deletePhone(@PathVariable(value = "id") UUID phoneId) throws Exception {
    Phone phone = phoneRepository.findById(phoneId).orElseThrow(() -> new Exception("Phone " + phoneId + " not found"));

    phoneRepository.delete(phone);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
