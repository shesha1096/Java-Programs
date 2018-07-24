package com.threading.examples;

class ThreadComm {




	private static Logic logic = new Logic();

	public static void main(String[] args) {

		new Thread(new Runnable(){




			@Override

			public void run() {

				

				logic.fact();

				

			}

			

			

		}).start();

		

			new Thread(new Runnable(){




				@Override

				public void run() {

					

					logic.readNum();

					

				}

				

				

			}).start();

			

			

			

			

			

	}




}
