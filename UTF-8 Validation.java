class Solution {
  public boolean validUtf8(int[] data) {

    int bits = 0;

    for (int i = 0; i < data.length; i++) 
    {
      String s = Integer.toBinaryString(data[i]);
        
      s = s.length() >= 8 ? s.substring(s.length() - 8) : "00000000".substring(s.length() % 8) + s;

      if (bits == 0) 
      {
        for (int j = 0; j < s.length(); j++) 
        {
          if (s.charAt(j) == '0') 
          {
            break;
          }
          bits += 1;
        }

        if (bits == 0) 
        {
          continue;
        }

        if (bits > 4 || bits == 1) 
        {
          return false;
        }

      } 
      else
      {
        if (!(s.charAt(0) == '1' && s.charAt(1) == '0'))
        {
          return false;
        }
      }

      bits -= 1;
    }

    return bits == 0;
  }
}
