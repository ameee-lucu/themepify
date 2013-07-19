package com.themepify.util;

import com.themepify.dto.UserDto;
import com.themepify.entity.Uploader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class UserMapper {

	public static UserDto map(Uploader uploader) {
			UserDto dto = new UserDto();
			dto.setId(uploader.getId());
//			dto.setFirstName(uploader.getFirstName());
//			dto.setLastName(uploader.getLastName());
			dto.setUsername(uploader.getName());
//			dto.setRole(uploader.getRole().getRole());
			return dto;
	}
	
	public static Uploader map(UserDto dto) {
		Uploader uploader = new Uploader();
//		uploader.setFirstName(dto.getFirstName());
//		uploader.setLastName(dto.getLastName());
		uploader.setName(dto.getUsername());
		
		PasswordEncoder encoder = new Md5PasswordEncoder();
		uploader.setPassword(encoder.encodePassword(dto.getPassword(), null));
		return uploader;
}
	
	public static List<UserDto> map(List<Uploader> uploaders) {
		List<UserDto> dtos = new ArrayList<UserDto>();
		for (Uploader uploader: uploaders) {
			dtos.add(map(uploader));
		}
		return dtos;
	}
}
