import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.String;

class Stringcalculator {
    public int add(String numbers) throws Exception {
        int sum = 0;

        if (numbers.length() == 0) {
            return sum;
        }

        List<String> delimiters = get_delims(numbers);
        sum = get_sum(get_numbers(numbers, delimiters));
        return sum;
    }

    private String[] get_numbers(String numbers, List<String> delimiters){

        String[] str = new String[0];
        StringBuilder num = new StringBuilder(numbers.substring(get_index(numbers)));
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < delimiters.size(); i++) {
            String delimiter = delimiters.get(i);
            Pattern r = Pattern.compile(delimiter);
            str = r.split(num);
            num = new StringBuilder();
            for (String s : str) {
                num.append(s);

                try{
                    num.append(delimiters.get(i + 1));
                } catch (Exception ignored){}
            }

            for (int j = 0; j < num.length(); j++) {
                ret.add(String.valueOf(num.charAt(j)));
            }

            for (int k = 0; k < ret.size(); k++) {
                ret.remove("\\");
            }
            num = new StringBuilder();
            for (String s : ret){
                num.append(s);
            }
            ret.clear();
        }
        return str;
    }

    private int get_sum(String[] numbers) throws Exception{
        int sum = 0;
        for (String s : numbers) {
            if(Objects.equals(s, "")){
                continue;
            }
            int k = Integer.parseInt(s);
            if (k < 0) Negative_exception(numbers);
            if (k > 1000) continue;
            sum+=k;
        }
        return sum;
    }

    private void Negative_exception(String[] numbers) throws Exception{
        List<Integer> negatives = new ArrayList<>();
        for (String s : numbers){
            if(Objects.equals(s, "")){
                continue;
            }
            int k = Integer.parseInt(s);
            if (k<0) {
                negatives.add(k);
            }
        }
        System.out.println("The negatives - "+negatives);
        throw new Exception("You tried to enter negatives");
    }

    private int get_index(String numbers){
        for (int i = 0; i<numbers.length();i++){
            if (numbers.charAt(i)=='\n' && numbers.charAt(i-1)==']'){
                return i+1;
            }
        }
        return 0;
    }

    private List<String> get_delims(String string) throws Exception {
        check_delimiters(string);
        char[] str = string.toCharArray();
        List<String> delimiters = new ArrayList<>();
        if(!(str[0]=='/' && str[1]=='/')){
            return Arrays.asList("\\n", ",");
        }
        else if ((str[2]=='[')){
            List<String> characters = new ArrayList<>();
            int k = check_input(str);
            int i = 3;
            while (i<k){
                if(str[i]==']' && str[i+1]!='['){
                    StringBuilder delimiter = new StringBuilder();
                    for (String c : characters) {
                        if (metacheck(c.charAt(0))) delimiter.append("\\");
                        delimiter.append(c);
                    }
                    delimiters.add(delimiter.toString());
                    break;
                }
                if (str[i]==']' && str[i+1]=='[') {
                    StringBuilder delimiter = new StringBuilder();
                    for (String c : characters) {
                        if (metacheck(c.charAt(0))) delimiter.append("\\");
                        delimiter.append(c);

                    }
                    delimiters.add(delimiter.toString());
                    characters.clear();
                }
                else {
                    characters.add(String.valueOf(str[i]));
                    if (Objects.equals(characters.get(0), "]")) characters.remove("]");
                    if (Objects.equals(characters.get(0), "[")) characters.remove("[");
                }
                i++;
            }
            sort(delimiters);
            return  delimiters;
        }
        return Arrays.asList("\\n", ",");
    }

    private void sort(List<String> s){

        String[] delims = new String[s.size()];

        for (int k = 0 ; k< delims.length; k++){
            delims[k] = s.get(k);
        }

        for (int i=1 ;i<delims.length; i++)
        {
            String temp = delims[i];
            int j = i - 1;
            while (j >= 0 && temp.length() > delims[j].length())
            {
                delims[j+1] = delims[j];
                j--;
            }
            delims[j+1] = temp;
        }
        s.clear();
        s.add("\\n");
        s.add(",");
        s.addAll(Arrays.asList(delims));
    }

    private void check_delimiters(String string) throws Exception{
        char[] str = string.toCharArray();
        Pattern r = Pattern.compile("((\\n)|,)");
        Matcher m = r.matcher(string);
        while (m.find()){
            if (!(Character.isDigit(str[m.end()]) | str[m.end()]=='-')){
                throw new Exception("Not allowed to double delimiters");
            }
        }
    }

    private boolean metacheck(char chr){
        char[] metacharacters = {'^','|','.','$','?','*','+','\\', '(', ')', '{', '['};
        for (char c : metacharacters){
            if (chr == c) return true;
        }
        return false;
    }

    private int check_input(char[] str) throws Exception{
        int k = 0;
        for (;k<str.length;k++){
            if (str[k+1]=='\n' && str[k]==']'){
                return k+1;
            }
        }
        throw new Exception("Unknown format");
    }
}
