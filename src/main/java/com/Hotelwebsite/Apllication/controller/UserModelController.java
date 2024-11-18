package com.Hotelwebsite.Apllication.controller;

import com.Hotelwebsite.Apllication.exception.ResourceNotFoundException;
import com.Hotelwebsite.Apllication.model.UserModel;
import com.Hotelwebsite.Apllication.service.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservations")
public class UserModelController {

    @Autowired
    private UserModelService userModelService;

    // Get all reservations
    @GetMapping
    public String getAllReservations(Model model) {
        List<UserModel> reservations = userModelService.findAll();
        model.addAttribute("reservations", reservations);
        return "reservations"; // Return the name of the HTML template (reservations.html)
    }

    // Get reservation by ID
    @GetMapping("/{id}")
    public String getReservationById(@PathVariable Long id, Model model) {
        UserModel reservation = userModelService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
        model.addAttribute("reservation", reservation);
        return "reservation-details"; // Return the name of the HTML template (reservation-details.html)
    }

    // Create a new reservation (show form)
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("reservation", new UserModel());
        return "reservation02-form.html"; // Return the name of the HTML template (reservation02
        // -form.html.html)
    }

    // Process new reservation
    @PostMapping
    public String createReservation(@ModelAttribute UserModel userModel) {
        userModelService.save(userModel);
        return "redirect:/congratulation"; // Redirect to the list of reservations
    }

    // Update an existing reservation (show form)
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        UserModel reservation = userModelService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
        model.addAttribute("reservation", reservation);
        return "reservation-form.html"; // Return the name of the HTML template (reservation-form.html.html)
    }

//    // Process updated reservation
//    @PostMapping("/{id}")
//    public String updateReservation(@PathVariable Long id, @ModelAttribute UserModel userModel) {
//        userModelService.update(id, userModel)
//                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
//        return "redirect:/reservations"; // Redirect to the list of reservations
//    }

    // Delete a reservation
    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        userModelService.deleteById(id);
        return "redirect:/reservations"; // Redirect to the list of reservations
    }
}
