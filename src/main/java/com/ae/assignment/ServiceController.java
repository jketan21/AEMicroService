package com.ae.assignment;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
	
	private static Queue<UserInfo> queue = new LinkedBlockingQueue();
	
	//GET call to get the users info(username & city - this is consumer which reads from queue)
	@GetMapping("/userinfo")
    public UserInfo getUserInfo() {
		
		System.out.println("hi");
		return queue.poll();
    }

	//POST call to create username & city - this is producer which enters data in queue)
	@PostMapping("/userinfo")
	 public void userInfo(@RequestBody UserInfo user) {
		queue.add(user);
		System.out.println(" user info ");
		
	  }
}
