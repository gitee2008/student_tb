ʹ��CustomProperties��ȡ���Ե������ļ��ŵ���Ŀ¼��


	public static String getString(String key) {
		if (hasObject(key)) {
			String value = properties.getProperty(key);
			if (value == null) {
				value = properties.getProperty(key.toUpperCase());
			}
			return value;
		}
		return null;
	}