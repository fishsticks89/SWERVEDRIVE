<script lang="ts">
	import Wheel from './../lib/Wheel.svelte';
    import doop from "$lib/doop";
    import { onDestroy } from 'svelte';
    // const doop = [[-90, 45, 0, 0]];
    let index = 0;
    let robotX: number;
    let robotY: number;
    let rotation: number; // counterclock
    const d = setInterval(() => {
        index += 5;
        if (index >= 4999) {
            index = 0
        }
        const time = index / 1000.0;
        robotX = 2;
        robotY = 1 + time * 1;
        rotation = time * -90;
    }, 10);
    onDestroy(() => {
        clearInterval(d);
    })
</script>

<Wheel wheelOrientation={doop[index][0] + rotation} robotOrientation={rotation} robotX={robotX} robotY={robotY} wheelIndex={0}/>
<Wheel wheelOrientation={doop[index][1] + rotation} robotOrientation={rotation} robotX={robotX} robotY={robotY} wheelIndex={1}/>
<Wheel wheelOrientation={doop[index][2] + rotation} robotOrientation={rotation} robotX={robotX} robotY={robotY} wheelIndex={2}/>
<Wheel wheelOrientation={doop[index][3] + rotation} robotOrientation={rotation} robotX={robotX} robotY={robotY} wheelIndex={3}/>
