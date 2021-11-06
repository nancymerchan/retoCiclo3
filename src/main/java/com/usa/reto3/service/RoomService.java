package com.usa.reto3.service;

import com.usa.reto3.model.Room;
import com.usa.reto3.repository.RoomRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author nancy
 */
@Service
public class RoomService {

    @Autowired

    private RoomRepository crudMetodos;

    public List<Room> getAll() {
        return crudMetodos.getAll();
    }

    public Optional<Room> getRoom(int roomId) {
        return crudMetodos.getRoom(roomId);
    }

    public Room save(Room room) {
        if (room.getId() == null) {
            return crudMetodos.save(room);

        } else {

            Optional<Room> evt = crudMetodos.getRoom(room.getId());
            if (evt.isEmpty()) {
                return crudMetodos.save(room);

            } else {
                return room;

            }

        }

    }
    public Room update(Room room) {
      if(room.getIdRoom()!=null){
            Optional<Room> evt=crudMetodos.getRoom(room.getIdRoom());
            if(!evt.isEmpty()){
                if(room.getName()!=null){
                    evt.get().setName(room.getName());
                    }
                if(room.getStars()!=null){
                    evt.get().setStars(room.getStars());
                    }
                if(room.getYear()!=null){
                    evt.get().setYear(room.getYear());
                    }
                crudMetodos.save(evt.get());
                return room;
                }
            else{
                return room;
            }
        }
        else{
            return room;
                }
        }

    public boolean deleteRoom(int id) {
        int Id = 0;
         Boolean aBoolean = getRoom(Id).map(room ->{
            crudMetodos.delete(room);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    }
    
    

        