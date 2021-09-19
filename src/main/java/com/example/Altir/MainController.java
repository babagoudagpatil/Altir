package com.example.Altir;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Altir.schemas.Rooms;
import com.example.Altir.service.HotelService;

@RestController
public class MainController {

	@Autowired
	HotelService hotelService;
	
	@RequestMapping(path = "/viewrooms",method = RequestMethod.GET)
	public ResponseEntity<List<Rooms>> getRooms() throws Exception
	{
		return ResponseEntity.ok(hotelService.getRooms());
	}
	
	@RequestMapping(path = "/addroom",method = RequestMethod.POST)
	public ResponseEntity<String> addRoom(@RequestHeader String adminId,@RequestBody Rooms room) throws Exception
	{
		try {
		return ResponseEntity.ok(hotelService.addRoom(room,adminId));
		}
		catch(Exception e)
		{
			return Response.badRequest(e.getMessage());
		}
	}
	
	@RequestMapping(path = "/removeroom",method = RequestMethod.DELETE)
	public ResponseEntity<String> removeRoom(@RequestHeader String adminId,@RequestHeader Integer roomnumber) throws Exception
	{
		try {
		return ResponseEntity.ok(hotelService.removeRoom(roomnumber,adminId));
		}
		catch(Exception e)
		{
			return Response.badRequest(e.getMessage());
		}
	}
	
	@RequestMapping(path = "/updateroom",method = RequestMethod.PUT)
	public ResponseEntity<String> removeRoom(@RequestHeader String adminId,@RequestBody Rooms room) throws Exception
	{
		try {
		return ResponseEntity.ok(hotelService.updateRoom(room,adminId));
		}
		catch(Exception e)
		{
			return Response.badRequest(e.getMessage());
		}
	}
	
//	@RequestMapping(path="/book",method=RequestMethod.POST)
//	public ResponseEntity<String> removeRoom(@RequestHeader List<LocalDate> localdate,@RequestBody List<Rooms> room) throws Exception
//	{
//		try {
//		return ResponseEntity.ok(hotelService.updateRoom(room,adminId));
//		}
//		catch(Exception e)
//		{
//			return Response.badRequest(e.getMessage());
//		}
//	}
	
	
}
