package az.edu.itbrains.Phaethon_Final_Lap.conrollers;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.categoryForProduct.CategoryForProductDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.consultation.ConsultationDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.product.ProductDetailDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.service.ServiceDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.deliveryService.DeliveryDetailDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.serviceInfo.ServiceInfoDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.supportCard.SupportCardDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.timeSlot.TimeSlotDTO;
import az.edu.itbrains.Phaethon_Final_Lap.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ServiceController {
    private final ConsultationService consultationService;
    private final DeliveryServiceService deliveryServiceService;
    private final ServiceService serviceService;
    private final CategoryForProductService categoryForProductService;
    private final ProductService productService;
    private final SupportCardService supportCardService;
    private final TimeSlotService timeSlotService;
    private final ServiceInfoService serviceInfoService;


    //TODO: CATDIRILMA SERVICE START
    @GetMapping("/services")
    public String serviceInfoPage(Model model) {
        List<ServiceInfoDTO> serviceInfoDTOList = serviceInfoService.getAllServiceInfo();
        List<ServiceDTO> serviceDTOList = serviceService.getAllServices();
        model.addAttribute("services", serviceDTOList);
        model.addAttribute("serviceInfos", serviceInfoDTOList);
        return "service/service.html";
    }
    @GetMapping("/services/catdirilma")
    public String serviceDetailPage(Model model) {
        List<DeliveryDetailDTO> deliveryDetailDTOS = deliveryServiceService.findById(1L);
        model.addAttribute("serviceDetails", deliveryDetailDTOS);
        return "service/deliveryDetail.html";
    }
    //TODO: CATDIRILMA SERVICE END


    //TODO: MESLEHETLESME SERVICE START

    @GetMapping("/services/meslehetlesme")
    public String serviceConsultationPage(Model model) {
        List<ConsultationDTO> consultationDTOS = consultationService.getAllConsultationsByServiceId(3L);
        model.addAttribute( "consultations", consultationDTOS);
        return "service/consultation.html";
    }

    @GetMapping("/services/meslehetlesme/{id}")
    public String serviceBookingPage(@PathVariable Long id, Model model) {
        ConsultationDTO consultationDTO = consultationService.findById(id);
        List<TimeSlotDTO> slots = timeSlotService.getSlotsForWeek(LocalDate.now());
        model.addAttribute("timeSlots", slots);
        model.addAttribute("consultation", consultationDTO);
        return "service/consultationDetail.html";
    }
    @PostMapping("/services/meslehetlesme/{slotId}/{userId}/{consultationId}")
    public String bookService(@PathVariable Long slotId, @PathVariable Long userId, @PathVariable Long consultationId, Model model) {
        TimeSlotDTO bookedSlot = timeSlotService.bookSlot(slotId, userId, consultationId);
        model.addAttribute("bookedSlot", bookedSlot);
        return "service/consultationDetail.html";
    }
    @GetMapping("/services/booking/confirm/{slotId}")
    public String bookingConfirmation(@PathVariable Long slotId, Model model) {
        model.addAttribute("slotId", slotId);
        return "service/bookingConfirmation.html";
    }
    //TODO: MESLEHETLESME SERVICE END


    //TODO: zemanet-ve-destek SERVICE START
    @GetMapping("/services/zemanet-ve-destek")
    public String serviceGuarantee(Model model) {
       List<SupportCardDTO> serviceInfoDTOList = supportCardService.findById(2L);
        model.addAttribute("supportCards", serviceInfoDTOList);
        return "service/guarantee.html";
    }
    //TODO: zemanet-ve-destek SERVICE END


    @GetMapping("/services/sifaris-et-ve-al")
    public String serviceOrderAndBuy(@RequestParam(required = false) Long categoryId, Model model) {
        List<CategoryForProductDTO> categoryForProductDTOS = categoryForProductService.getAllCategoryForProduct();
        List<ProductDetailDTO> productDetailDTOS = productService.getFilteredProducts(categoryId);
        model.addAttribute("products", productDetailDTOS);
        model.addAttribute("categories", categoryForProductDTOS);
        model.addAttribute("selectedCategoryId", categoryId);
        return "service/orderAndBuy.html";
    }

    @GetMapping("/services/sifaris-et-ve-al/detail/{id}")
    public String productDetailPage(@PathVariable Long id, Model model) {
        ProductDetailDTO productDetailDTO = productService.getProductById(id);
        model.addAttribute("product", productDetailDTO);
        return "service/orderAndBuyDetail.html";
    }
}
