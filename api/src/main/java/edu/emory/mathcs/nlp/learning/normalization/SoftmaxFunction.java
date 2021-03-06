/**
 * Copyright 2015, Emory University
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.emory.mathcs.nlp.learning.normalization;

import edu.emory.mathcs.nlp.common.util.DSUtils;
import org.apache.commons.math3.util.FastMath;

/**
 * @author amit-deshmane
 *
 */
public class SoftmaxFunction implements NormalizationFunction {

	private static final long serialVersionUID = -2922860244331616104L;

	public SoftmaxFunction() {
	}

	/* (non-Javadoc)
	 * @see edu.emory.mathcs.nlp.learning.normalization.NormalizationFunction#apply(float[])
	 */
	@Override
	public void apply(float[] scores)
	{
		float sum = 0, max = DSUtils.max(scores);
		max = 0;
		
		for (int i=0; i<scores.length; i++)
		{
			scores[i] = (float)FastMath.exp(scores[i] - max);
			sum += scores[i];
		}
		
		if(sum != 0){
			sum = 1f / sum;
		}
		
		for (int i=0; i<scores.length; i++)
			scores[i] *= sum;
	}
	
	@Override
	public String toString()
	{
		return "Normalization-Softmax";
	}

}
