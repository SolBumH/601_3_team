package com.team_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.team_3.service.GalleryService;

@RestController
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
		
}
