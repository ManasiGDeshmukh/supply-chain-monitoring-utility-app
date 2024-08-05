package com.walmart.supplyChain.Service.Impl;

import com.walmart.supplyChain.Entity.Track;
import com.walmart.supplyChain.Repository.TrackRepository;
import com.walmart.supplyChain.Service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    @Autowired
    private TrackRepository trackRepository;

    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    public Optional<Track> getTrackById(Long id) {
        return trackRepository.findById(id);
    }

    public Track saveTrack(Track track) {
        return trackRepository.save(track);
    }

    public void deleteTrack(Long id) {
        trackRepository.deleteById(id);
    }
}
