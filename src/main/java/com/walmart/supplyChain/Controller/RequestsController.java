package com.walmart.supplyChain.Controller;

import com.walmart.supplyChain.Entity.Requests;
import com.walmart.supplyChain.Service.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/requests")
public class RequestsController {
    @Autowired
    private RequestsService requestsService;

    @GetMapping
    public List<Requests> getAllRequests() {
        return requestsService.getAllRequests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Requests> getRequestsById(@PathVariable Long id) {
        Optional<Requests> request = requestsService.getRequestsById(id);
        return request.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Requests createRequests(@RequestBody Requests request) {
        return requestsService.saveRequests(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Requests> updateRequests(@PathVariable Long id, @RequestBody Requests requestDetails) {
        Optional<Requests> request = requestsService.getRequestsById(id);
        if (request.isPresent()) {
            Requests updatedRequest = request.get();
            updatedRequest.setUserID(requestDetails.getUserID());
            updatedRequest.setProdID(requestDetails.getProdID());
            updatedRequest.setQuantity(requestDetails.getQuantity());
            updatedRequest.setTotalCost(requestDetails.getTotalCost());
            updatedRequest.setDateOfReq(requestDetails.getDateOfReq());
            updatedRequest.setComment(requestDetails.getComment());
            updatedRequest.setType(requestDetails.getType());
            return ResponseEntity.ok(requestsService.saveRequests(updatedRequest));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequests(@PathVariable Long id) {
        requestsService.deleteRequests(id);
        return ResponseEntity.noContent().build();
    }
}
