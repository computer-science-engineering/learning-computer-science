using System;

namespace TruckLoadingTotalWeight.Solution
{
    public class Engine
    {        
        public Engine() 
        {
        }

        public int getWeight(string input) 
        {
            int totalWeight = 0;
            string[] items = input.Split(" ");
            foreach(var item in items)
            {
                totalWeight += getWeightForEachItem(item);
            }
            return totalWeight;            
        }
        
        public int getWeightForEachItem(string item)
        {
            char[] characters = item.ToCharArray();
            bool isAdd = false;
            if (characters[0] == '+')
            {
                isAdd = true;
            }
            int indexOfB = item.IndexOf('b');
            if (indexOfB == -1) // +50
            {
                if (isAdd)
                {
                    return Int32.Parse(item.Substring(1, characters.Length-1));
                }
                else 
                {
                    return Int32.Parse(item.Substring(1, characters.Length-1)) * -1;
                }
            }
            else // +50b8
            {
                int weight = Int32.Parse(item.Substring(indexOfB+1));
                int length = indexOfB - 1;
                int count = Int32.Parse(item.Substring(1, length));
                int totalWeight = weight * count;
                if (isAdd)
                { 
                    return totalWeight;
                }
                else 
                {
                    return totalWeight * -1;
                }
            }
        }
    }
}