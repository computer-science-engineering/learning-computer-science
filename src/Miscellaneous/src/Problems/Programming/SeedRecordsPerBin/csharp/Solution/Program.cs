using System;

namespace SeedRecordsPerBin.Solution
{
    class Program
    {
        static void Main(string[] args)
        {                      
            int[] seeds = new int[]{22000, 28000, 25000, 33000, 21000, 24000, 32000, 18000, 30000, 31000, 23000, 19000};
            Engine engine = new Engine();
            engine.Orchestrator(seeds);
        }
    }
}
