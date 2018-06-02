/*
We are writing an IDE for object-oriented programmers, and working on the autocompletion feature. Because class names can be long, we want to allow users to only type the beginning of the initial words in a name -- so, instead of "GraphViewController", they could type "Gra" or "GraViC". (Each word in the name will always start with a capital letter.)

Given a list of class names and an input string, return all the possible autocompletions for that input string. (Autocompletions always start from the beginning, so "Data" does not match "DetailedDataView".)

Assume the inputs are small enough that you don't need to optimize your function.

class_names = [
  "GraphView",
  "DetailedDataView",
  "DataGraphView",
  "DataController",
  "GraphViewController",
  "MouseClickHandler",
  "MathCalculationHandler",
  "DataScienceView",
]


autocomplete(class_names, "Data")            
# Expected output: [DataController, DataGraphView, DataScienceView]

autocomplete(class_names, "GVi")
# Expected output: [GraphView, GraphViewController]

autocomplete(class_names, "MCHandler")
# Expected output: [MouseClickHandler, MathCalculationHandler]

autocomplete(class_names, "MoCHandler")
# Expected output: [MouseClickHandler]

autocomplete(class_names, "MathHandler")
# Expected output: []

autocomplete(class_names, "DataScienceViewController")
# Expected output: []


 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
class Indeed {

    public static List<String> splitStrings(String data) {
        List<String> prefixes = new ArrayList<String>();
        int lastPref = 0;
        for (int i = 0; i < data.length(); i++) {
            if (Character.isUpperCase(data.charAt(i)) && i - 1 >= 0) {
                String prefix = data.substring(lastPref, i);
//                System.out.println(prefix);
                prefixes.add(prefix);
                lastPref = i;
            }
        }
        prefixes.add(data.substring(lastPref, data.length()));
        return prefixes;
    }

    public static List<String> findMatch(String[] classNames, String data) {

        List<String> dataPrefList = splitStrings(data);
        System.out.println(Arrays.toString(dataPrefList.toArray()));
        List<String> result = new ArrayList<>();

        for (String item : classNames) {
            if (item.startsWith(data)) {
                result.add(item);
            } else {
                boolean found = true;
                List<String> classPrefs = splitStrings(item);
                System.out.println(Arrays.toString(classPrefs.toArray()));
//                System.out.println(Arrays.toString(prefixes.toArray()));
                for(int i=0;i<dataPrefList.size();i++) {
                    String pref=dataPrefList.get(i);
                    String cPref=classPrefs.get(i);
                    if (cPref.startsWith(pref)) {
                            
                    } else {
                        found = false;
                        break;
                    }
                }
                
                if (found) {
                    result.add(item);
                }
            }

        }

        return result;
    }

    //Write your function here
    public static int[] findOutlier(List<List<Integer>> lists) {
        int[] resultArr = new int[lists.size()];
        int i = 0;
        for (List<Integer> list : lists) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int listItem : list) {
                map.put(listItem, map.getOrDefault(listItem, 0) + 1);
            }

            for (HashMap.Entry<Integer, Integer> item : map.entrySet()) {
                int key = item.getKey();
                int val = item.getValue();
                if (val == 1) {
                    resultArr[i++] = key;
                    break;
                }
            }
        }
        return resultArr;
    }

    public static void main(String[] args) {
        String[] classNames = new String[]{
            "GraphView",
            "DetailedDataView",
            "DataGraphView",
            "DataController",
            "GraphViewController",
            "MouseClickHandler",
            "MathCalculationHandler",
            "DataScienceView"
        };

        List<String> list = findMatch(classNames, "GVi");

        System.out.println(Arrays.toString(list.toArray()));

//     List<List<Integer>> inputLists = Arrays.asList(
//       Arrays.asList(1, 2, 1),
//       Arrays.asList(2, 2, 2, 2, 2, 6, 2),
//       Arrays.asList(3, 1, 1, 1),
//       Arrays.asList(9, 9, 4)
//     );
//     int[] arr=findOutlier(inputLists);
//     System.out.println(Arrays.toString(arr));
    }
}
