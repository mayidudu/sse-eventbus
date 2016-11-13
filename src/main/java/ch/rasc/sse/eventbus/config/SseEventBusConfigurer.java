/**
 * Copyright 2016-2016 Ralph Schaer <ralphschaer@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.rasc.sse.eventbus.config;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Defines methods for configuring the SSE Event Bus library.
 *
 * <p>
 * Used together with {@link EnableSseEventBus}
 */
public interface SseEventBusConfigurer {

	/**
	 * The internal scheduler runs with a fixed delay of this value.
	 * <p>
	 * Default: 200 milliseconds
	 */
	default int schedulerDelayInMilliseconds() {
		return 200;
	}

	/**
	 * Specifies after how many seconds a stale client is removed from the internal
	 * registry
	 *
	 * Default: 86 400 seconds (1 day)
	 */
	default int clientExpirationInSeconds() {
		return 86_400;
	}

	/**
	 * Specifies after how many seconds a stale message is removed from the internal
	 * registry
	 *
	 * Default: 120 seconds
	 */
	default int messageExpirationInSeconds() {
		return 120;
	}

	/**
	 * Number of failed tries to send a response before the client is removed from the
	 * internal database.
	 */
	default int noOfSendResponseTries() {
		return 20;
	}

	/**
	 * A task scheduler that schedules the interal event loop that sends the sse messages
	 * to the clients.
	 * <p>
	 * By default this is an instance created with
	 * {@link Executors#newSingleThreadScheduledExecutor()}
	 */
	default ScheduledExecutorService taskScheduler() {
		return null;
	}

}