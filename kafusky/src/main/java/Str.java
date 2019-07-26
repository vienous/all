import java.util.*;

public class Str {
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 2000; i++) {
			if (i == 1999) {
				stringBuilder.append(i + "39484;");
			} else {
				stringBuilder.append(i + "39484,");
			}
		}
		for (int i = 0; i < 2000; i++) {
			if (i == 1999) {
				stringBuilder.append("0.4565639484");
			} else {
				stringBuilder.append("0.4565639484,");
			}
		}

		StringBuilder stringBuilder1 = new StringBuilder();
		for (int i = 0; i < 2000; i++) {
			if (i == 1999) {
				stringBuilder1.append(i + "39484:0.4565639484");
			} else {
				stringBuilder1.append(i + "39484:0.4565639484,");
			}
		}
		List<List<String>> lists = str(stringBuilder.toString());
		Map<String, String> list1 = str1(stringBuilder.toString());
		long start = System.currentTimeMillis();
		parse(stringBuilder.toString());
		System.out.println(String.format("time(list to map) :%s", System.currentTimeMillis() - start));
		map(stringBuilder1.toString());
		map1(stringBuilder1.toString());
		System.out.println("done");

	}

	public static Map<String, String> parse(String s) {
		char[] chars = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		LinkedHashMap<String, String> result = new LinkedHashMap<>();
		Iterator<String> keys = null;
		boolean isTerm = true;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c != ',' && c != ';') {
				sb.append(c);
			} else if (c == ',') {
				if (isTerm) {
					result.put(sb.toString(), null);
					sb = new StringBuffer();
				} else {
					result.put(keys.next(), sb.toString());
					sb = new StringBuffer();
				}
			} else {
				result.put(sb.toString(), null);
				sb = new StringBuffer();
				isTerm = false;
				keys = result.keySet().iterator();
			}
		}
		result.put(keys.next(), sb.toString());
		return result;
	}


	public static List<List<String>> str(String string) {
		long start = System.currentTimeMillis();
		List<String> termIdList = new ArrayList<>();
		List<String> weightList = new ArrayList<>();
		StringBuilder stringBuilder = new StringBuilder();
		boolean flag = true;
		for (int i = 0; i < string.length(); i++) {
			if (i == string.length() - 1) {
				weightList.add(stringBuilder.toString());
			}
			if (string.charAt(i) == ';') {
				flag = false;
				termIdList.add(stringBuilder.toString());
				stringBuilder = new StringBuilder();
				continue;
			}
			if (flag) {
				if (string.charAt(i) != ',') {
					stringBuilder.append(string.charAt(i));

				} else {
					termIdList.add(stringBuilder.toString());
					stringBuilder = new StringBuilder();
				}
			} else {
				if (string.charAt(i) != ',') {
					stringBuilder.append(string.charAt(i));

				} else {
					weightList.add(stringBuilder.toString());
					stringBuilder = new StringBuilder();
				}
			}
		}
		List<List<String>> lists = new ArrayList<>();
		lists.add(weightList);
		lists.add(termIdList);
		System.out.println(String.format("time(list to list) :%s", System.currentTimeMillis() - start));
		return lists;
	}

	public static Map<String, String> str1(String string) {
		long start = System.currentTimeMillis();
		String[] s = string.split(";");

		Map<String, String> map = new HashMap<>();

		String[] s1 = s[0].split(",");
		String[] s2 = s[0].split(",");
		for (int i = 0; i < s1.length; i++) {
			map.put(s1[i], s2[i]);
		}
		System.out.println(String.format("time(list split to map) :%s", System.currentTimeMillis() - start));
		return map;
	}

	public static Map<String, String> map(String string) {
		long start = System.currentTimeMillis();
		Map<String, String> map = new HashMap<>();
		String[] s = string.split(",");
		for (int i = 0; i < s.length; i++) {
			String[] s1 = s[i].split(":");
			map.put(s1[0], s1[1]);
		}
		System.out.println(String.format("time(kv split to map) :%s", System.currentTimeMillis() - start));
		return map;
	}

	public static Map<String, String> map1(String string) {
		long start = System.currentTimeMillis();
		Map<String, String> map = new HashMap<>();
		StringBuilder stringBuilder = new StringBuilder();
		String key = "";
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != ',' && string.charAt(i) != ':') {
				stringBuilder.append(string.charAt(i));
			} else if (string.charAt(i) == ':') {
				key = stringBuilder.toString();
				stringBuilder = new StringBuilder();
			} else {
				map.put(key, stringBuilder.toString());
				stringBuilder = new StringBuilder();
			}
		}
		System.out.println(String.format("time(kv to map) :%s", System.currentTimeMillis() - start));
		return map;
	}
}
