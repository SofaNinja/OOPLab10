package functions;

import result.Result;

public class CalculatorProcessor implements ICalculator {

    public Result calculatorIntegral(int intervals, int threads) {
        double a = 0;
        double b = 1;

        double delta = (b - a) / threads;
        totalResult = 0;
        finished = 0;
        double eps = Math.E;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threads; i++) {
            IntegralCalculator calculator = new IntegralCalculator(
                    a + i * delta,
                    a + i * delta + delta,
                    intervals / threads, t -> Math.pow(eps, t) * Math.sqrt(Math.pow(eps, t) - 1 * delta * t),
                    this);
            new Thread(calculator).start();
        }
        try {
            synchronized (this) {
                while (finished < threads) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted");
        }
        long finishTime = System.currentTimeMillis();
        return new Result(totalResult, finishTime - startTime);
    }
    private double totalResult;
    private int finished;
    public synchronized void send(double v) {
        totalResult += v;
        finished++;
        notify();
    }
}