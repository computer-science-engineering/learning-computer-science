using System;
using Solution;
using Xunit;
using System.Collections.Generic;

namespace SolutionTest
{
    public class EngineTests
    {
        [Fact]
        public void TrivialTest1()
        {
            // ====Arrange====
            int[] seeds = new int[]{22000, 28000, 25000, 33000, 21000, 24000, 32000, 18000, 30000, 31000, 23000, 19000};
            Dictionary<String, int> expected = new Dictionary<string, int>() 
            {
                { "bin2", 3 },
                { "bin3", 3 },
                { "bin1", 6 }
            };

            Engine engine = new Engine();

            // ====Act====
            engine.Orchestrator(seeds);

            // ====Assert====
            Assert.Equal(expected, engine.BinCount);
        }
    }
}
