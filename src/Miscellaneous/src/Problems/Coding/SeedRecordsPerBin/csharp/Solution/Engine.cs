using System;
using System.Threading;
using System.Collections.Concurrent;

namespace SeedRecordsPerBin.Solution
{
    public class Engine
    {        
        private enum Bin 
        {
            bin1,
            bin2,
            bin3,
            bin4
        }

        public Engine() 
        {
            BinCount = new ConcurrentDictionary<string, int>();
        }
        
        public ConcurrentDictionary<string, int> BinCount 
        {
            get; private set;
        }

        public void Orchestrator(int[] seeds)
        {   
            foreach (var seed in seeds) 
            {
                string binStr = getBin(seed);
                if (BinCount.TryGetValue(binStr, out int extantVal)) 
                {
                    BinCount.TryUpdate(binStr, extantVal+1, extantVal);
                }
                else 
                {
                    BinCount.TryAdd(binStr, 1);
                }
                //BinCount.AddOrUpdate(binStr, 
            }
            
            foreach(var key in BinCount.Keys) 
            {
                if (BinCount.TryGetValue(key, out int val))
                {            
                    Console.WriteLine("Bin-" + key + " : " + val);
                }
            }            
        }

        private string getBin(int seeds) 
        {
            try 
            {
                if (seeds < 25000) 
                {
                    return Bin.bin1.ToString();
                }
                else if (25000 <= seeds && seeds <= 30000) 
                { 
                    return Bin.bin2.ToString();
                }
                else if (seeds > 30000) 
                { 
                    return Bin.bin3.ToString();
                }
                else if (seeds < 25000 || seeds > 30000) 
                { 
                    return Bin.bin4.ToString();
                }
            }
            catch (Exception ex) 
            {
                Console.WriteLine(ex);
                throw;
            }
            
            return Bin.bin1.ToString();
        }
    }
}