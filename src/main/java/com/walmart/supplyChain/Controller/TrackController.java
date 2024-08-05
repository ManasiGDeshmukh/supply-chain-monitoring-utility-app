package com.walmart.supplyChain.Controller;

import com.walmart.supplyChain.Entity.Track;
import com.walmart.supplyChain.Service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/track")
public class TrackController {
    @Autowired
    private TrackService trackService;

    @GetMapping
    public List<Track> getAllTrack() {
        return trackService.getAllTrack();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Track> getTrackById(@PathVariable Long id) {
        Optional<Track> track = trackService.getTrackById(id);
        return track.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Track createTrack(@RequestBody Track track) {
        return trackService.saveTrack(track);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Track> updateTrack(@PathVariable Long id, @RequestBody Track trackDetails) {
        Optional<Track> track = trackService.getTrackById(id);
        if (track.isPresent()) {
            Track updatedTrack = track.get();
            updatedTrack.setEstDeliveryDate(trackDetails.getEstDeliveryDate());
            updatedTrack.setCurrStatus(trackDetails.getCurrStatus());
            updatedTrack.setFromLocation(trackDetails.getFromLocation());
            updatedTrack.setToLocation(trackDetails.getToLocation());
            updatedTrack.setComments(trackDetails.getComments());
            return ResponseEntity.ok(trackService.saveTrack(updatedTrack));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrack(@PathVariable Long id) {
        trackService.deleteTrack(id);
        return ResponseEntity.noContent().build();
    }
}
