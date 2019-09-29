package hee.leetcode;

public class DefangIPaddr_1108 {
    public static final String REPLACE_STR = "[.]";

    public String defangIPaddr(String address) {
        address = address.replace( ".", REPLACE_STR);
        return address;
    }
}
