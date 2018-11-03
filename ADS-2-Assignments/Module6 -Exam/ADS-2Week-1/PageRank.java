class PageRank {
	private Digraph dig;
	private double[] prvalue;
	PageRank(final Digraph d) {
		this.dig = d;
		//int vertices = dig.V(); 
		prvalue = new double[dig.V()];
		for (int i = 0; i < prvalue.length; i++) {
			prvalue[i] = 1 / dig.V();
		}
		getPR();
	}

	public void getPR() {
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < dig.V(); j++) {
				double result = 0.0;
				for(int k : dig.adj(j)) {
					result += (prvalue[k]/dig.outdegree(k));
				}
				prvalue[j] = result;
			}
		}
	}

	// public String toString() {
	// 	StringBuilder s = new StringBuilder();
	// 	for (int i = 0; i < dig.V(); i++) {
	// 		System.out.println(i + "-" + getPR(i));
	// 	}
	// }
}
