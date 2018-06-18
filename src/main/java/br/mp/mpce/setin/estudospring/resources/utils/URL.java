package br.mp.mpce.setin.estudospring.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {
	
	public static List<Integer> decodeInsList(String s){
		String[] vetor = s.split(",");
		List<Integer> list = new ArrayList<>();
		for (String x: vetor) {
			list.add(Integer.parseInt(x));
		}
		return list;
	}
	
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

}
