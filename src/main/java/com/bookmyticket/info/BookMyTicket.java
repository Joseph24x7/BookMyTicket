package com.bookmyticket.info;

import java.util.List;
import java.util.Map;

import com.bookmyticket.entity.Theatre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BookMyTicket {
	
	private Map<String, List<Theatre>> recommendedMovies;
	private Theatre theatre;
	
}