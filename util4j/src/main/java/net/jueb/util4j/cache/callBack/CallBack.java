package net.jueb.util4j.cache.callBack;

import java.util.Optional;

/**
 * 回调
 * @author Administrator
 * @param <T>
 */
@FunctionalInterface
public interface CallBack<R> {

	/**
	 * 默认超时时间
	 */
	public static long DEFAULT_TIMEOUT=10*1000;
	
	public default void  call(boolean timeOut){
		call(timeOut,Optional.ofNullable(null));
	}
	
	public default void  call(boolean timeOut,R result){
		call(timeOut,Optional.ofNullable(result));
	}
	
	/**
	 * 回调
	 * @param timeOut 是否超时
	 * @param result 可选结果,如果没有超时则可能有结果
	 */
	public abstract void call(boolean timeOut,Optional<R> result);
}