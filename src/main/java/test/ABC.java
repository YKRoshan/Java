package test;


import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class ABC {
    public static void main(String[] args) {
        //prints b
        System.out.println(kthMostFrequentChar("aaabbacccd",3));
        //prints b
        System.out.println(kthMostFrequentChar("aaabbacccbbbd",1));
        //prints e
        System.out.println(kthMostFrequentChar("aaabbbcccdddeee",5));

    }

    private static String kthMostFrequentChar(String str, final int k) {
        Map<Integer, Long> counts = str.chars()
            .boxed()
            .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
            ));
        char ch= counts.entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .map(e->(char)e.getKey().intValue())
            .limit(k)
            .reduce((l,r)->r)
            .orElseThrow(IllegalArgumentException::new);
      return   Character.toString(ch);
    }

}
/*

public class ABC{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            String S = br.readLine().trim();
            int K = Integer.parseInt(br.readLine().trim());
            String out_ = KFrequency(S, K);
            wr.println(out_);
        }

        wr.close();
        br.close();
    }

    static String KFrequency(String S, int k) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i=0;i<S.length();i++) {
            Character ch=S.charAt(i);
            Integer x = map.get(ch);
            if (x == null) x = 0;
            map.put(ch, ++x);
        }

        List list = new ArrayList(map.entrySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                Integer v1 = (Integer) ((Map.Entry) o1).getValue();
                Integer v2 = (Integer) ((Map.Entry) o2).getValue();
                return v1.compareTo(v2);
            }
        });

        if (list.size() > k) return (String) (list.get(k));
        return Integer.toString(-1);
        // Write your code here
        // HashMap<Character,Integer> map=new HashMap<>();
        // for(int i=0;i<S.length();i++){
        //     char ch=s.charAt(i);
        //     if(map.containsKey(ch)){
        //         int v=map.get(ch);
        //         map.put(ch,++v);
        //     }else{
        //         map.put(ch,1);
        //     }
        // }
        //       Collections.sort(map,(i1,i2) -> i1.getValue()
        //       .compareTo(i2.getValue()));


    }
}
*/
