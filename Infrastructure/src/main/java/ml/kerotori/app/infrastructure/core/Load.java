package ml.kerotori.app.infrastructure.core;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public interface Load<T> {
	@SuppressWarnings("unchecked")
	public static <T>  T loadXml(String fileName) {

		try (XMLDecoder decoder = new XMLDecoder(
				new BufferedInputStream(
						new FileInputStream(fileName)))) {
			return (T) decoder.readObject();
		} catch (FileNotFoundException e) {
			return null;
		}catch(Exception e) {
			return null;
		}
	}
}
