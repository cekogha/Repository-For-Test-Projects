package fr.cekogha.marshaller;

import java.util.List;

public interface IMarshaller {

	public <T> T deserializeToObject(String content, T clazz);

	public <T> List<T> deserializeToList(String content, T clazz);

	public <T> List<T> deserializeToList(List<String> contentList, T clazz);
}
