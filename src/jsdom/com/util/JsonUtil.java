package jsdom.com.util;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {

	public static JSONObject toJson(List<Object> list) { 
		if (list == null)
			return null;
		
		JSONArray jsonArray = JSONArray.fromObject(list); 
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("list", jsonArray); 

		return JSONObject.fromObject(map); 
	}
	
}
