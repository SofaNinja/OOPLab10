package functions;

import result.Result;

public interface ICalculator {
    Result calculatorIntegral(int intervals, int threads);
}