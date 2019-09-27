package com.epam.thread.trst;


import com.epam.thread.trst.WaitingPool;
import com.epam.thread.trst.Train;
import com.epam.thread.trst.WaitingPoolMonitorThread;
import com.epam.thread.trst.TrainThread;
import com.epam.thread.trst.DispatcherThread;
import com.epam.thread.trst.CreatorThread;
import com.epam.thread.trst.Tunnel;

public class MainClas{

	public static void main(String[] args) {
		Tunnel tunnelTrue = new Tunnel(true);
		Tunnel tunnelFalse = new Tunnel(false);
		WaitingPool waitingPool = new WaitingPool();

		CreatorThread creator = new CreatorThread(waitingPool);
		creator.start();

		WaitingPoolMonitorThread poolMonitor = new WaitingPoolMonitorThread(waitingPool);
		poolMonitor.setDaemon(true);
		poolMonitor.start();

		DispatcherThread dispatcher = new DispatcherThread(waitingPool, tunnelTrue, tunnelFalse);
		dispatcher.setDaemon(true);
		dispatcher.start();
	}
}
