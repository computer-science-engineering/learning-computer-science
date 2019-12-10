using System;

namespace TruckLoadingTotalWeight.Solution
{
    class Program
    {
        static void Main(string[] args)
        {                      
            string input = "+6b25 +50 -2b25 +10b20 -50";
            Engine engine = new Engine();
            Console.WriteLine(engine.getWeight(input));
        }
    }
}
