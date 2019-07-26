public class ByteTest {
	/**
	 * 数组越界
	 * 这个方法是java源码中常用的一个数组越界的判断检测
	 * 顺便复习一下位操作
	 */
	public static int read(byte[] b, int off, int len) throws Exception {
		// parameter check
		int result = off | len | (off + len) | (b.length - (off + len));
		if (result < 0) {
			System.out.println(result);
		} else if (len == 0) {
			return 0;
		}
		return result;
	}

	/**
	 * 将一个高位在前的字节数组转为int
	 *
	 * @param num
	 * @return
	 */
	public static byte[] intToBytes(int num) {
		byte[] bytes = new byte[4];
		bytes[0] = (byte) (num >>> 24);
		bytes[1] = (byte) (num >>> 16);
		bytes[2] = (byte) (num >>> 8);
		bytes[3] = (byte) (num >>> 0);
		return bytes;
	}

	/**
	 * 将一个高位在前的字节数组转为int
	 *
	 * @param bytes
	 * @return
	 */
	public static int byteToInt(byte[] bytes) {
		int _1 = bytes[0] << 24;
		int _2 = bytes[1] << 16;
		int _3 = bytes[2] << 8;
		int _4 = bytes[3] << 0;
		return _1 | _2 | _3 | _4;
	}

	/**
	 * 显示一个byte数组
	 *
	 * @param bytes
	 */
	public static void showByte(byte[] bytes) {
		for (byte b : bytes) {
			System.out.print(byteToBit(b) + " ");
		}
		System.out.println();
		for (byte b : bytes) {
			System.out.print(b);
		}
	}

	/**
	 * 将byte转换为一个长度为8的byte数组，数组每个值代表bit
	 */
	public static byte[] getBooleanArray(byte b) {
		byte[] array = new byte[8];
		for (int i = 7; i >= 0; i--) {
			array[i] = (byte) (b & 1);
			b = (byte) (b >> 1);
		}
		return array;
	}

	/**
	 * 把byte转为字符串的bit
	 */
	public static String byteToBit(byte b) {
		return ""
				+ (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
				+ (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
				+ (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
				+ (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
	}

	public static void main(String[] args) {
		int num = 100;
		byte[] bytes = intToBytes(num);
		showByte(bytes);
		num = byteToInt(bytes);
		System.out.println(num);
	}
}