package space.harbour.l81.io;

import java.io.*;

/**
 * Created by tully.
 */
class JavaIO {

    static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }

    static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }

    static void writeObject(String file, Object student) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            BufferedOutputStream bus = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bus);
            oos.writeObject(student);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Object readObject(String file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return  null;
        }
    }
}
