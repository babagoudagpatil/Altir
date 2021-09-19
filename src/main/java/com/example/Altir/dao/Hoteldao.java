package com.example.Altir.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Altir.schemas.Admin;
import com.example.Altir.schemas.Booking;
import com.example.Altir.schemas.Rooms;

@Repository
public class Hoteldao {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;

	public List<Rooms> getRooms()
	{
		EntityManager em=entityManagerFactory.createEntityManager();
		Query q=em.createQuery("Select r from Rooms r");
		List<Rooms> rooms=q.getResultList();
		
		return rooms;
	}
	
	public void addRoom(Rooms room) throws Exception
	{
		EntityManager em=entityManagerFactory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		if(em.find(Rooms.class, room.getRoomnumber())!=null)
		{
			throw new Exception("Room number Already Exists");
		}
		et.begin();
		em.persist(room);
		et.commit();
	}
	
	public void removeRoom(Integer roomnumber) throws Exception
	{
		EntityManager em=entityManagerFactory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Rooms room=em.find(Rooms.class, roomnumber);
		if(room==null)
		{
			throw new Exception("Room number Does not Exists");
		}
		et.begin();
		em.remove(room);
		et.commit();
	}
	
	public void updateroom(Rooms room) throws Exception
	{
		EntityManager em=entityManagerFactory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Rooms roomEntity=em.find(Rooms.class, room.getRoomnumber());
		if(roomEntity==null)
		{
			throw new Exception("Room number Does not Exists");
		}
		et.begin();
		roomEntity.setRoomdescription(room.getRoomdescription());
		roomEntity.setRoomprice(room.getRoomprice());
		roomEntity.setRoomstatus(room.getRoomstatus());
		roomEntity.setRoomtype(room.getRoomstatus());
		et.commit();
	}
	
	public Boolean isAdmin(String adminId)
	{
		EntityManager em=entityManagerFactory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		if(em.find(Admin.class, adminId)!=null)
			return true;
		return false;
		
	}
	
	public String bookRoomsDate(LocalDate date,List<Rooms> rooms)
	{
		EntityManager em=entityManagerFactory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		for(Rooms r:rooms)
		{
			et.begin();
			em.persist(r);
			et.commit();
		}
		
		return "Booked Sucessfully";
	}
	
	public String bookRoomsDate(Rooms rooms,List<LocalDate> dates)
	{
		EntityManager em=entityManagerFactory.createEntityManager();
		EntityTransaction et=em.getTransaction();
		for(LocalDate date:dates)
		{
			Booking booking=em.find(Booking.class, rooms.getRoomnumber());
			et.begin();
			booking.setBookingdate(date);
			em.persist(booking);
			et.commit();
		}
		
		return "Booked Sucessfully";
	}
}
