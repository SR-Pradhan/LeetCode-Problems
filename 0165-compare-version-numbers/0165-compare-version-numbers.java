class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");

        int i = 0;

        while (i < Math.max(ver1.length, ver2.length)) {
            int num1 = 0;
            int num2 = 0;

            if (i < ver1.length) {
                num1 = Integer.parseInt(ver1[i]);
            }

            if (i < ver2.length) {
                num2 = Integer.parseInt(ver2[i]);
            }

            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }

            i++;
        }

        return 0;
    }
}