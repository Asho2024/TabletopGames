package players.heuristics;

import core.AbstractGameState;
import core.interfaces.IStateFeatureVector;


public class LinearStateHeuristic extends AbstractStateHeuristic {

    public LinearStateHeuristic(String featureVectorClassName, String coefficientsFile) {
        super(featureVectorClassName, coefficientsFile);
    }
    public LinearStateHeuristic(IStateFeatureVector featureVector, String coefficientsFile) {
        super(featureVector, coefficientsFile);
    }

    @Override
    public double evaluateState(AbstractGameState state, int playerId) {
        if (coefficients == null)
            return defaultHeuristic.evaluateState(state, playerId);
        double[] phi = features.featureVector(state, playerId);
        double retValue = 0.0;
        for (int i = 0; i < phi.length; i++) {
            retValue += phi[i] * coefficients[i];
        }
        return retValue;
    }
}
