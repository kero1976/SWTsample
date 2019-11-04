package ml.kerotori.app.infrastructure.core;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public interface Save<T> {
	public static <T> boolean saveXml(String fileName, T obj) {
		// オブジェクトのデータを保存
		try (XMLEncoder encoder = new XMLEncoder(
				new BufferedOutputStream(
						new FileOutputStream(fileName)))) {
			encoder.writeObject(obj);
		} catch (FileNotFoundException e) {
			return false;
		}catch(Exception e) {
			return false;
		}
		return true;
	}
}
