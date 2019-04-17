using System;
using TruckLoadingTotalWeight.Solution;
using Xunit;

namespace TruckLoadingTotalWeight.SolutionTest
{
    public class EngineTests
    {
        [Fact]
        public void TrivialTest1()
        {
            // ====Arrange====
            string input = "+6b25 +50 -2b25 +10b20 -50";
            int expected = 300;

            Engine engine = new Engine();

            // ====Act====
            int actual = engine.getWeight(input);

            // ====Assert====
            Assert.Equal(expected, actual);
        }
    }
}
