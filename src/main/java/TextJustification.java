import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> output = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int lineLength = 0;
        int pos = 0;
        while(pos < words.length) {
            if (lineLength == 0 || lineLength + words[pos].length() + 1 <= maxWidth) {
                line.add(words[pos]);
                if (lineLength == 0) lineLength = words[pos].length();
                else lineLength += words[pos].length() + 1;
                ++pos;
            } else {
                int spacesToAdd = maxWidth - lineLength;
                if (line.size() > 1) {
                    int spacesEachGap = (spacesToAdd / (line.size() - 1)) + 1;
                    int numGapsAdditionalSpace = spacesToAdd % (line.size() - 1);
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i < line.size() - 1; ++i) {
                        sb.append(line.get(i));
                        for(int j = 0; j < (i < numGapsAdditionalSpace ? spacesEachGap + 1 : spacesEachGap); ++j)
                            sb.append(' ');
                    }
                    sb.append(line.get(line.size() - 1));
                    output.add(sb.toString());
                } else {
                    // Left justification if there is only one word
                    StringBuilder sb = new StringBuilder();
                    sb.append(line.get(0));
                    for(int i = 0; i < spacesToAdd; ++i)
                        sb.append(' ');
                    output.add(sb.toString());
                }
                line.clear();
                lineLength = 0;
            }
        }

        // Last line is left justification
        StringBuilder sb = new StringBuilder();
        sb.append(line.get(0));
        for (int i = 1; i < line.size(); ++i) {
            sb.append(' ');
            sb.append(line.get(i));
        }
        for (int i = 0; i < maxWidth - lineLength; ++i)
            sb.append(' ');
        output.add(sb.toString());

        return output;
    }
}
