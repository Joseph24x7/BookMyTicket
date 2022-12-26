package com.bookmyticket.entity;

import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "TheatreInfo")
public class Theatre {
	
	@Id
	private ObjectId uniqueId;
	
	@Indexed(unique=true)
	private String theatreCode;
	
	private String theatreName;
	
	private Integer pincode;
	
	private Set<Movie> movieDetails;

	public Theatre(String theatreName, Integer pincode) {
		super();
		this.theatreName = theatreName;
		this.pincode = pincode;
	}

}
