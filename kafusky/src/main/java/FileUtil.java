import java.io.*;

public class FileUtil {

	public static void mergeFile(String filepath, String outPath) throws IOException {

		try {
			File file = new File(filepath);
			if (!file.isDirectory()) {
				System.out.println("文件");
				System.out.println("path=" + file.getPath());

			} else if (file.isDirectory()) {
				File out = new File(outPath);
				FileOutputStream fos = new FileOutputStream(out);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
				System.out.println("文件夹");
				String[] fileList = file.list();
				for (int i = 0; i < fileList.length; i++) {
					System.out.println(i + " : " + fileList[i]);
					if (fileList[i].equals(".DS_Store")) {
						continue;
					}
					File text = new File(filepath + "/" + fileList[i]);
					InputStreamReader inputReader = new InputStreamReader(new FileInputStream(text));
					BufferedReader bf = new BufferedReader(inputReader);
					String str;
					while ((str = bf.readLine()) != null) {
						bw.write(str);
						bw.newLine();
					}
					bf.close();
					inputReader.close();
				}
				bw.close();
				fos.close();
				System.out.println("done");
			}
		} catch (FileNotFoundException e) {
			System.out.println("readfile()   Exception:" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		try {
			wirteFile("/Users/fengqinghua/cut.txt", "/Users/fengqinghua/weight.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void wirteFile(String filepath, String outPath) throws IOException {

		try {
			File file = new File(filepath);

			File out = new File(outPath);
			FileOutputStream fos = new FileOutputStream(out);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader bf = new BufferedReader(inputReader);
			String str;
			while ((str = bf.readLine()) != null) {
				String[] s = str.split(":");
				String termId = s[0];
				String[] weights = s[1].split(",");
				bw.write(termId + ":" + weights[weights.length - 1]);
				bw.newLine();
			}
			bf.close();
			inputReader.close();
			bw.close();
			fos.close();
			System.out.println("done");
		} catch (FileNotFoundException e) {
			System.out.println("readfile()   Exception:" + e.getMessage());
		}
	}
}
