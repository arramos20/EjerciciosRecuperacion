package com.salesianostriana.primerodam.dao;

import com.salesianostriana.primerodam.modelo.Alumno;
import java.util.List;

public interface CrudAlumno {

    public default List<Alumno> findAll(){
        return null;
    }

    public default Alumno findOne(long id){
        return null;
    }

    public default void insert(Alumno alumno){

    }

    public default void edit(Alumno alumno){

    }

    public default void delete(Alumno alumno){

    }

}
