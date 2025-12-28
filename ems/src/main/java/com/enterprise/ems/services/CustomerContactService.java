package com.enterprise.ems.services;
import com.enterprise.ems.dtos.CustomerContactFilter;
import com.enterprise.ems.entities.CustomerContact;
import com.enterprise.ems.helper.CustomerContactExcelHelper;
import com.enterprise.ems.repositories.CustomerContactRepository;
import jakarta.transaction.Transactional;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.io.ByteArrayOutputStream;

import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
/*import org.apache.poi.ss.usermodel.Cell;*/
/*import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/

@Service
public class CustomerContactService {
    @Autowired
    private CustomerContactRepository customerContactRepository;

    @Transactional

     public  CustomerContact addContact(CustomerContact body){
        return  customerContactRepository.save(body);
    }

    public Page<CustomerContact> getAllContact(String searchTerm, Pageable pageable) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return customerContactRepository.findAll(pageable);
        } else {
            return customerContactRepository.searchContact(searchTerm, pageable);
        }
    }


    public CustomerContact updateCustomerContact(Long id, CustomerContact updatedCustomerContact) {
        return customerContactRepository.findById(id)
                .map(existingCustomerContact -> {
                    existingCustomerContact.setName(updatedCustomerContact.getName());
                    existingCustomerContact.setPincode(updatedCustomerContact.getPincode());
                    existingCustomerContact.setEmail(updatedCustomerContact.getEmail());
                    existingCustomerContact.setPhone(updatedCustomerContact.getPhone());
                    existingCustomerContact.setAddress(updatedCustomerContact.getAddress());
                    existingCustomerContact.setLanguage(updatedCustomerContact.getLanguage());
                    return customerContactRepository.save(existingCustomerContact);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    public Optional<CustomerContact> getContactById(Long id) {
        return customerContactRepository.findById(id);
    }


    public void deleteContact(Long  id) {
        customerContactRepository.deleteById(id);
    }

    public void upload(MultipartFile file){


       try {
           List<CustomerContact> data = CustomerContactExcelHelper.convertExcelToList(file.getInputStream());
           this.customerContactRepository.saveAll(data);
       } catch (IOException e) {
          e.printStackTrace();
       }
    }





    public int bulkDelete(List<Long> ids) {

        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("ID list cannot be empty");
        }

        customerContactRepository.deleteByIdIn(ids);
        return ids.size();
    }


    // Fetch filtered or all data
    public List<CustomerContact> getCustomerContacts(CustomerContactFilter filter) {
        List<CustomerContact> all = customerContactRepository.findAll();

        // Apply filters dynamically
        return all.stream()
                .filter(c -> filter.getName() == null || c.getName().contains(filter.getName()))
                .filter(c -> filter.getEmail() == null || c.getEmail().contains(filter.getEmail()))
                .filter(c -> filter.getPhone() == null || c.getPhone().contains(filter.getPhone()))
                .filter(c -> filter.getLanguage() == null || c.getLanguage().contains(filter.getLanguage()))
                .filter(c -> filter.getPincode() == null || c.getPincode().contains(filter.getPincode()))
                .collect(Collectors.toList());
    }

    // Export Excel
    public ByteArrayInputStream exportToExcel(CustomerContactFilter filter) {

        List<CustomerContact> customers = getCustomerContacts(filter);

        try (XSSFWorkbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("Customers");

            Row headerRow = sheet.createRow(0);
            String[] headers = {"ID", "Name", "Email", "Phone", "Language", "Address", "Pincode"};
            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            int rowIdx = 1;
            for (CustomerContact customer : customers) {
                Row row = sheet.createRow(rowIdx++);
                /*row.createCell(0).setCellValue(customer.getId());*/
                row.createCell(1).setCellValue(customer.getName());
                row.createCell(2).setCellValue(customer.getEmail());
                row.createCell(3).setCellValue(customer.getPhone());
                row.createCell(4).setCellValue(customer.getLanguage());
                row.createCell(5).setCellValue(customer.getAddress());
                row.createCell(6).setCellValue(customer.getPincode());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());

        } catch (Exception e) {
            throw new RuntimeException("Failed to export data to Excel", e);
        }
    }
}
