package prathi.learn.practicealg.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class SubDomainVisitCount {

    public static void main(String[] args) {
        String[] str = new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> result = subdomainVisits(str);

        for (String res: result) {
            System.out.println(res);
        }
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String domain: cpdomains) {
            String[] subdomain = domain.split(Pattern.quote(" "))[1].split(Pattern.quote("."));
            int count = Integer.parseInt(domain.split(Pattern.quote(" "))[0]);
            String str = "";
            for (int i= subdomain.length -1; i >= 0; i--) {
                if (str.length() == 0)
                    str = subdomain[i];
                else
                    str = subdomain[i] + "." + str;
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + count);
                } else {
                    map.put(str, count);
                }
            }
        }

        map.forEach((k, v) -> {
            String domainCOunt = v +" " + k;
            result.add(domainCOunt);
        });

        return result;

    }
}
