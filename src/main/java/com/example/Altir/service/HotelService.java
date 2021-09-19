package com.example.Altir.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Altir.dao.Hoteldao;
import com.example.Altir.schemas.Rooms;

@Service
public class HotelService {

	@Autowired
	Hoteldao hoteldao;
	public List<Rooms> getRooms()
	{
		return hoteldao.getRooms();
	}
	
	public String addRoom(Rooms room, String adminId)  throws Exception
	{
		if(!hoteldao.isAdmin(adminId))
			throw new Exception("Not Allowed need Admin Access");
		hoteldao.addRoom(room);
		return "Room added Successfully";
	}
	
	public String removeRoom(Integer roomnumber, String adminId)  throws Exception
	{
		if(!hoteldao.isAdmin(adminId))
			throw new Exception("Not Allowed need Admin Access");
		hoteldao.removeRoom(roomnumber);
		return "Room removed Successfully";
	}
	
	public String updateRoom(Rooms room, String adminId) throws Exception
	{
		if(!hoteldao.isAdmin(adminId))
			throw new Exception("Not Allowed need Admin Access");
		hoteldao.updateroom(room);
		return "Room updated Successfully";
	}
}
